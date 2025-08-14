from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class SimilarityRequest(BaseModel):
    text: str
    scope: str | None = None

class SimilarityResponse(BaseModel):
    similarityScore: float

class GradeRequest(BaseModel):
    text: str
    scope: str | None = None

class GradeResponse(BaseModel):
    score: float
    feedback: str

@app.get("/healthz")
def healthz():
    return {"ok": True}

@app.post("/similarity", response_model=SimilarityResponse)
def similarity(req: SimilarityRequest):
    return {"similarityScore": 0.0}

@app.post("/grade-openended", response_model=GradeResponse)
def grade(req: GradeRequest):
    return {"score": 0.0, "feedback": ""}
