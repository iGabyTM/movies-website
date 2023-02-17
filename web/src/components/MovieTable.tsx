import React, {FC, useEffect, useState} from 'react';
import {Paper, Table, TableBody, TableCell, TableHead, TableRow} from "@mui/material";
import {Movie} from "../model/Movie";
import {MovieService} from "../service/MovieService";

const service = new MovieService();

export const MovieTable: FC = () => {
    function createMovieRows(array: Movie[]): JSX.Element[] {
        return array.map(movie => (
            <TableRow id={`movie-${movie.id}`}>
                <TableCell>{movie.id}</TableCell>
                <TableCell>{movie.title}</TableCell>
                <TableCell>{movie.releaseYear}</TableCell>
                <TableCell>{movie.genre}</TableCell>
            </TableRow>
        ));
    }

    const [movies, setMovies] = useState<Movie[]>([]);

    useEffect(() => {
        service.getMovies(data => setMovies(data))
    }, [])

    return (
        <>
            <Paper sx={{marginTop: "10px"}}>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>Id</TableCell>
                            <TableCell>Title</TableCell>
                            <TableCell>Release Year</TableCell>
                            <TableCell>Genre</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>{createMovieRows(movies)}</TableBody>
                </Table>
            </Paper>
        </>
    );
};
