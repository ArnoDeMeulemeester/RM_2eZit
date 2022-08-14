const express = require("express");

const {
  getBook,
  getBooks,
  setBook,
  updateBook,
  deleteBook,
} = require("../service/books.js");

const router = express.Router();

router.get("/", getBooks);
router.get("/:id", getBook);
router.post("/", setBook);
router.put("/:id", updateBook);
router.delete("/:id", deleteBook);

module.exports = router;
