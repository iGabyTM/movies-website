import React, {FC} from "react";
import {AppBar, Toolbar, Typography} from "@mui/material";

export const Navigation: FC = () => {
    return (
        <AppBar position="static">
            <Toolbar variant="dense">
                <Typography variant="h6" color="inherit" component="div">
                    Photos
                </Typography>
            </Toolbar>
        </AppBar>
    )
}