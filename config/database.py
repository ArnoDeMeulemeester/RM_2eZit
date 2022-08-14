from pymongo import MongoClient
import certifi

ca = certifi.where()

client = MongoClient(
    "mongodb+srv://arvid:Arvid123@cluster0.jdojdw3.mongodb.net/MyFirstDatabase?retryWrites=true&w=majority", tlsCAFile=ca)

db = client.todo_application
collection_name = db["book_app"]
