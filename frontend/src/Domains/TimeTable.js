import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function TimeTable() {
  // const baseUrl = "http://localhost:8080/demo/api/domain/getschedule/1";
  // const callAPI = async(id) => {
  //     const url = baseUrl +id;
  //     const response = await axios.get(url);
  //     console.log(response.data);
  // }

  const [schedule, setCors] = useState(null);
  const { id } = useParams();
  useEffect(() => {
    loadCors();
  }, []);

  const loadCors = async () => {
    const res = await axios.get(
      `http://localhost:8080/demo/api/domain/getschedule/${id}`
    );
    console.log(res.data);
    setCors(res.data);
  };

  if (schedule == null) return;

  return (
    <div className="cointainer">
      <div>
        <h1 className="display-4">
          <b>Time Table</b>
        </h1>
        <br></br>
        <table className="table table-warning shadow table-hover table-striped table-bordered ">
          <thead className="table-dark">
            <tr>
              <th scope="col">TIME</th>
              <th style={{ width: "20%" }} scope="col">
                MONDAY
              </th>
              <th style={{ width: "20%" }} scope="col">
                TUESDAY
              </th>
              <th style={{ width: "20%" }} scope="col">
                WEDNESDAY
              </th>
              <th style={{ width: "20%" }} scope="col">
                THURSDAY
              </th>
              <th style={{ width: "20%" }} scope="col">
                FRIDAY
              </th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <th className="table-dark">9:30AM-11:00AM</th>
              <td>{schedule[0].MON}</td>
              <td>{schedule[0].TUE}</td>
              <td>{schedule[0].WED}</td>
              <td>{schedule[0].THU}</td>
              <td>{schedule[0].FRI}</td>
            </tr>
            <tr>
              <th className="table-dark">11:30AM-1:00PM</th>
              <td>{schedule[1].MON}</td>
              <td>{schedule[1].TUE}</td>
              <td>{schedule[1].WED}</td>
              <td>{schedule[1].THU}</td>
              <td>{schedule[1].FRI}</td>
            </tr>
            <tr>
              <th className="table-dark">2PM-3:30PM</th>
              <td>{schedule[2].MON}</td>
              <td>{schedule[2].TUE}</td>
              <td>{schedule[2].WED}</td>
              <td>{schedule[2].THU}</td>
              <td>{schedule[2].FRI}</td>
            </tr>
            <tr>
              <th className="table-dark">4PM-5:30PM</th>
              <td>{schedule[3].MON}</td>
              <td>{schedule[3].TUE}</td>
              <td>{schedule[3].WED}</td>
              <td>{schedule[3].THU}</td>
              <td>{schedule[3].FRI}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <Link className="btn btn-primary my-2" to={"/"}>
        Back To Previous Tab
      </Link>
    </div>
  );
}
