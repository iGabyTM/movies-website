import React, {FC} from "react";
import {MovieTable} from "./components/MovieTable";
import {Navigation} from "./components/Navigation";

const App: FC = () => {
    /*const movies: Movie[] = [
        {
            id: 1,
            title: "Doctor Strange",
            releaseYear: 2016,
            genre: Genre.SciFi
        },
        {
            id: 2,
            title: "Doctor Strange 2",
            releaseYear: 2022,
            genre: Genre.SciFi
        },
        {
            id: 3,
            title: "Some Comedy",
            releaseYear: 2020,
            genre: Genre.Comedy
        }
    ];*/

    return (
        <div className="App">
            <Navigation/>
            <MovieTable/>
        </div>
    )
}

export default App;
