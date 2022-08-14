const mongoose = require("mongoose");

const bookSchema = mongoose.Schema({
  titel: String,
  description: String,
});

module.exports = mongoose.model("Book", bookSchema);
