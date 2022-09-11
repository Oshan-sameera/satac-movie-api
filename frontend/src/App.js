import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import HeaderComponent from "./components/HeaderComponent";
import ListMoviesComponent from "./components/ListMoviesComponent";

function App() {
  return (
    <div>
      <HeaderComponent />
      <Router>
        <Routes>
          <Route exact path="/" element={<ListMoviesComponent />} />
          <Route path="/movies" element={<ListMoviesComponent />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
