from pydantic import BaseModel


class Book(BaseModel):
    titel: str
    description: str
