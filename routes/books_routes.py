from fastapi import APIRouter
from config.database import collection_name
from models.books_model import Book
from schemas.books_schema import book_serializer, books_serializer
from bson import ObjectId

router = APIRouter()

# Getter voor alle boeken


@router.get("/")
async def get_books():
    books = books_serializer(collection_name.find())
    return {"status": " ok", "data": books}

# krijg boek per id


@router.get("/{id}")
async def get_book(id):
    return books_serializer(collection_name.find({"_id": ObjectId(id)}))


# Maak nieuw boek aan
@router.post("/")
async def create_book(book: Book):
    _id = collection_name.insert_one(dict(book))
    return books_serializer(collection_name.find({"_id": _id.inserted_id}))

# Update boek met id


@router.put("/{id}")
async def update_book(id: str, book: Book):
    collection_name.find_one_and_update({"_id": ObjectId(id)}, {
        "$set": dict(book)
    })
    return books_serializer(collection_name.find({"_id": ObjectId(id)}))

# Delete boek met id


@router.delete("/{id}")
async def delete_book(id: str):
    collection_name.find_one_and_delete({"_id": ObjectId(id)})
    return {"status": "ok"}
