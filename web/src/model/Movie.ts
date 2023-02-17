export interface Movie {
    id: number,
    title: string,
    releaseYear: number,
    genre?: Genre
}

export enum Genre {
    Comedy = "😂 Comedy",
    Drama = "😱 Drama",
    SciFi = "👽 Sci Fi"
}