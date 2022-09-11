import React, { useState, useEffect } from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Container from "@mui/material/Container";
import Box from "@mui/material/Box";

import { Root, CustomTablePagination } from "../styles/styles";

import MovieService from "../service/MovieService";

const ListMoviesComponent = () => {
  const [title, setTitle] = React.useState("");
  const [year, setYear] = React.useState("");
  const [genre, setGenre] = React.useState("");
  const [movies, setMovies] = useState([]);
  const [loading, setLoading] = useState(false);

  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);

  useEffect(() => {
    setLoading(true);
    MovieService.defaultDetails()
      .then((response) => {
        setMovies(response.data);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  const submit = () => {
    MovieService.getAllMovies(title, year, genre)

      .then((response) => {
        setPage(0);
        setMovies(response.data);
      })
      .catch((err) => {
        alert(err.response.data.message);
      })
      .finally(() => {
        setLoading(false);
      });
  };

  const emptyRows =
    page > 0 ? Math.max(0, (1 + page) * rowsPerPage - movies.length) : 0;

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  if (loading)
    return (
      <div className="container">
        <h2 className="text-center">LOADING....</h2>
      </div>
    );
  return (
    <div>
      <Container fixed>
        <Box
          component="form"
          sx={{
            "& > :not(style)": { m: 1, width: "25ch" },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField
            id="outlined-basic"
            label="Tittle"
            variant="outlined"
            size="small"
            style={{ margin: "10px 10px 10px 0px" }}
            onChange={(e) => {
              setTitle(e.target.value);
            }}
          />

          <TextField
            id="outlined-basic"
            label="Year"
            type="number"
            variant="outlined"
            size="small"
            style={{ margin: "10px 10px 10px 0px" }}
            onChange={(e) => {
              setYear(e.target.value);
            }}
          />
          <TextField
            id="outlined-basic"
            label="Genre"
            variant="outlined"
            size="small"
            style={{ margin: "10px 10px 10px 0px" }}
            onChange={(e) => {
              setGenre(e.target.value);
            }}
          />

          <Button
            variant="outlined"
            onClick={submit}
            size="large"
            style={{ margin: "10px 10px 10px 0px" }}
          >
            SEARCH
          </Button>
        </Box>

        <Root sx={{ maxWidth: "100%" }}>
          <table aria-label="custom pagination table">
            <thead>
              <tr>
                <th>Title</th>
                <th>Year</th>
                <th>Casts</th>
                <th>Genres</th>
              </tr>
            </thead>
            <tbody>
              {(rowsPerPage > 0
                ? movies.slice(
                    page * rowsPerPage,
                    page * rowsPerPage + rowsPerPage
                  )
                : movies
              ).map((row) => (
                <tr key={row.title}>
                  <td style={{ width: "40%" }} align="right">
                    {row.title}
                  </td>
                  <td style={{ width: "10%" }} align="right">
                    {row.year}
                  </td>
                  <td style={{ width: "25%" }} align="right">
                    {row.cast}
                  </td>
                  <td style={{ width: "25%" }} align="right">
                    {row.genres}
                  </td>
                </tr>
              ))}
            </tbody>
            <tfoot>
              <tr>
                <CustomTablePagination
                  rowsPerPageOptions={[5]}
                  colSpan={3}
                  count={movies.length}
                  rowsPerPage={rowsPerPage}
                  page={page}
                  componentsProps={{
                    select: {
                      "aria-label": "rows per page",
                    },
                    actions: {
                      showFirstButton: true,
                      showLastButton: true,
                    },
                  }}
                  onPageChange={handleChangePage}
                />
              </tr>
            </tfoot>
          </table>
        </Root>
      </Container>
    </div>
  );
};

export default ListMoviesComponent;
