def book_serializer(book) -> dict:
    return {
        "id": str(book["_id"]),
        "titel": book["titel"],
        "description": book["description"],
    }

def books_serializer(books) -> list:
    return [book_serializer(book) for book in books]