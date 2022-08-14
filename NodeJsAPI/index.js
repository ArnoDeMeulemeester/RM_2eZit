const express = require("express");
const connectToMongo = require("./data/db.js");
const PORT = process.env.PORT || 9000;
const Cors = require("cors");
const morgan = require("morgan");

connectToMongo();

const app = express();

app.use(Cors());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(morgan("tiny"));

// BASISROUTES
app.use("/api/books", require("./rest/_books.js"));

app.listen(PORT, () => {
  console.log(`server draait op poort: ${PORT}`);
});
