const mongoose = require("mongoose");

const connectToMongo = async () => {
  try {
    const conn = await mongoose.connect(
      "mongodb+srv://arvid:Arvid123@cluster0.jdojdw3.mongodb.net/MyFirstDatabase?retryWrites=true&w=majority"
    );
    console.log(`MongoDB geconnecteerd: ${conn.connection.host}`);
  } catch (error) {
    console.log(error);
    process.exit(1);
  }
};

module.exports = connectToMongo;
