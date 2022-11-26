import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function Student() {
  const [students, setStudents] = useState([]);
  const { id } = useParams();

  useEffect(() => {
    loadStudents();
  }, []);

  const loadStudents = async () => {
    const result = await axios.get(
      `http://localhost:8080/demo/api/course/get/${id}`
    );
    setStudents(result.data);
    // console.log(result.data[0]);
    // console.log(students);
  };
  //   let obj = JSON.stringify(students[0]);

  if (students.length == 0) return null;

  console.log(students[0].course_id);

  return (
    <div className="container">
      <div className="py-4">
        {students.map((course) => (
          <div key={course.course_id}>
            {/* {course.course_name} */}
            <table className="table table-warning">
              <thead>
                <tr>
                  <th></th>
                  <th scope="col">Roll Number</th>
                  <th scope="col">First Name</th>
                  <th scope="col">Last Name</th>
                  <th scope="col">Email</th>
                </tr>
              </thead>
              <tbody>
                {course.studentsEnrolled.map((student) => (
                  <tr key={student.student_id}>
                    {/* <div key={student.student_id}></div> */}
                    <td></td>
                    <td>{student.roll_number}</td>
                    <td>{student.first_name}</td>
                    <td>{student.last_name}</td>
                    <td>{student.email}</td>
                  </tr>
                  //   </div>
                ))}
              </tbody>
            </table>
          </div>
        ))}
      </div>
      <Link className="btn btn-primary mx-2" to={"/viewTimeTable/1"}>
        Back
      </Link>
    </div>
  );
}
