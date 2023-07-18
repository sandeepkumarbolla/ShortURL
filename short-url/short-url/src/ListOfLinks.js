import React, { useEffect, useState } from 'react'
import axios from "axios"; 

export default function ListOfLinks() {
  const [links,setLinks] = useState([])

  useEffect(()=>{
   loadlinks();
  },[] );

  const loadlinks=async()=>{
    const result = await axios.get("http://localhost:8080/links");
    setLinks(result.data)
  }

  return (
    <div className='container'>
      <table className="table table-light table-striped-columns">
  <thead>
    <tr>
      <th scope='col'>index</th>
      <th scope="col">URL</th>
      <th scope="col">shortURL</th>
      <th scope="col">expiration time</th>
    </tr>
  </thead>
  <tbody>
    {
      links.map((link,index)=>(
        <tr>
          <th scope="row" key ={index}>{index+1} </th>
          <td>{link.url}</td>
          <td  class="clickable text-center">http://localhost:8080/{link.shurl}</td>
          <td>{link.date}</td>
        </tr>
      ))
    }
     
  </tbody>
</table>
    </div>
  )
}
