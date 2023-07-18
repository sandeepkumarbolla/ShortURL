import Navbar from "./Navbar";
import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ListOfLinks from "./ListOfLinks";
import ShortURL from "./ShortURL";

function App(){
    return(
        <div className="App">
            <Router>
       <Navbar/>
       

        <Routes>
            <Route exact path="/list" element= {<ListOfLinks/>}/>
            <Route exact path="/" element= {<ShortURL/>}/>
          
        </Routes>
      </Router>
    </div>
      
    )
}
export default App;