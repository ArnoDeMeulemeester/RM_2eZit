const asyncHandler = require("express-async-handler");

const Book = require("../repository/bookRepo.js");

//Getter voor alle boeken
const getBooks = asyncHandler(async (req, res) => {
  const books = await Book.find();
  res.status(200).json(books);
});

//Getter voor alle boeken met id
const getBook = asyncHandler(async (req, res) => {
  const books = await Book.find({ id: req.params.id });
  res.status(200).json(books);
});

//Maak nieuw boek aan
const setBook = asyncHandler(async (req, res) => {
  if (!req.body.titel || !req.body.description) {
    res.status(400).json({ message: "Gelieve beide variabelen in te vullen" });
  }

  const book = await Book.create({
    titel: req.body.titel,
    description: req.body.description,
  });

  res.status(201).json(book);
});

//Pas een Boek aan
const updateBook = asyncHandler(async (req, res) => {
  const book = await Book.findById(req.params.id);

  if (!book) {
    res.status(400).json({ message: "geen boek gevonden met dat id" });
  }
  const updatedBook = await Book.findByIdAndUpdate(req.params.id, req.body, {
    new: true,
  });

  res.status(200).json(updatedBook);
});

const deleteBook = asyncHandler(async (req, res) => {
  const book = await Book.findById(req.params.id);

  if (!book) {
    res.status(400).json({ message: "Boek niet gevonden" });
  }

  await book.remove();

  res.status(200).json({ id: req.params.id });
});

module.exports = {
  getBooks,
  setBook,
  updateBook,
  deleteBook,
  getBook,
};
