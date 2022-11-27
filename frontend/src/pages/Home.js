import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Home() {
  const [domains, setDomains] = useState([]);

  useEffect(() => {
    loadDomains();
  }, []);

  const loadDomains = async () => {
    const result = await axios.get(
      "http://localhost:8080/demo/api/domain/get_all"
    );
    setDomains(result.data);
    // console.log(result.data);
    // console.log(Object.keys(domains).length);
  };
  //console.log(courses);
  // for (const { domain_id: n } of domains) {
  //   console.log(n);
  // }
  return (
    <div className="container">
      <div className="py-4">
        <h1>Academic Programmes</h1>
        <table className="table table-secondary shadow table-hover table-striped">
          <thead className="table-dark">
            <tr>
              <th scope="col">Domain_ID</th>
              <th scope="col">Domain_Name</th>
              <th scope="col">Action</th>
              {/* <th scope="col">Courses</th> */}
            </tr>
          </thead>
          <tbody>
            {domains.map((domain, index) => (
              <tr key={domain.domain_id}>
                <td>{domain.domain_id}</td>
                <td>{domain.domain_name}</td>
                <td>
                  <Link
                    className="btn btn-primary mx-2"
                    to={`/TimeTable/${domain.domain_id}`}
                  >
                    View TimeTable
                  </Link>
                  <Link
                    className="btn btn-warning mx-2"
                    to={`/viewTimeTable/${domain.domain_id}`}
                  >
                    View Courses
                  </Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
