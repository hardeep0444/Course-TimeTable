import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import axios from "axios";

export default function ViewTimeTable() {
  const [courses1, setCourses] = useState([]);
  const { id } = useParams();
  useEffect(() => {
    loadCourses();
  }, []);

  const loadCourses = async () => {
    const result = await axios.get(
      `http://localhost:8080/demo/api/domain/get/${id}`
    );
    setCourses(result.data);
    // console.log(courses1);
  };

  //console.log(courses);.

  // for (const { coursesOffered: n } of courses1) {
  //   for (const { course_name: p, courseSchedules: m } of n) {
  //     console.log(p);
  //     for (const { day: k } of m) console.log(k);
  //   }
  // }

  for (const { coursesOffered: n } of courses1) {
    for (const { course_name: p, facultyName: f, courseSchedules: m } of n) {
      console.log(p);
      console.log(f);
      for (const { day: k, time: l, room: r } of m) {
        console.log(k);
        console.log(l);
        console.log(r);
      }
    }
  }

  return (
    <div className="container">
      {courses1.map((domain) => {
        return (
          <div key={domain.domain_id}>
            <h1 className="display-1">{domain.domain_name}</h1>

            {domain.coursesOffered.map((course) => (
              <div key={course.course_id}>
                <h1>
                  <u>{course.course_name}</u>
                </h1>

                {course.courseSchedules.map((timing) => (
                  <div key={timing.id}>
                    <h5>{timing.day}</h5>
                    <h6>{timing.time}</h6>
                    <h6>{timing.room}</h6>
                  </div>
                ))}
              </div>
            ))}
          </div>
        );
      })}
    </div>
  );
  // return (
  //   <div className="container">
  //     <div className="row">
  //       <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
  //         <h2 className="text-center m-4">Time Table</h2>
  //         <table className="table">
  //           <thead>
  //             <tr>
  //               <th scope="col">Course</th>
  //               <th scope="col">Time</th>
  //               <th scope="col">Day</th>
  //               <th scope="col">Room No.</th>
  //             </tr>
  //           </thead>
  //           <tbody>
  //             {/* {courses.map((course, index) => (
  //               <tr>
  //                 <th scope="row" key={index}>
  //                   {index + 1}
  //                 </th>
  //                 <td>
  //                   {course.coursesOffered[index].courseSchedules[index].time}
  //                 </td>
  //               </tr>
  //             ))} */}
  //           </tbody>
  //         </table>
  //         <Link className="btn btn-primary my-2" to={"/"}>
  //           Back To Home
  //         </Link>
  //       </div>
  //     </div>
  //   </div>
  // );
}
