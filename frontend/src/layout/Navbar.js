import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <div className="col" align="left">
            <a className="navbar-brand" href="/">
              IIITB Academic ERP
            </a>
          </div>
          <div className="col">
            <a>
              <img
                src={require("/home/hardeep/ESD/demoMini/frontend/src/IIITB Silver Jubilee Logo.jpg")}
                height="50px"
              />
            </a>
          </div>
          <div className="col" align="right">
            <Link className="btn btn-success" to={"/"}>
              Home
            </Link>
          </div>
        </div>
      </nav>
    </div>
  );
}
