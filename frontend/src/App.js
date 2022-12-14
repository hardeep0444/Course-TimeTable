import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import Home from "./pages/Home";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ViewTimeTable from "./Domains/ViewTimeTable";
import Student from "./Students/Student";
import TimeTable from "./Domains/TimeTable";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/viewTimeTable/:id" element={<ViewTimeTable />} />
          <Route exact path="/Student/:id" element={<Student />} />
          <Route exact path="/TimeTable/:id" element={<TimeTable />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
