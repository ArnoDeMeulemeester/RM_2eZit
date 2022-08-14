from fastapi import FastAPI
from routes.books_routes import router

app = FastAPI()

app.include_router(router)
