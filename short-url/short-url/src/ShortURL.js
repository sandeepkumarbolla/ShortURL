import axios from "axios";
import React, { useState } from "react"; 
import urlService1 from "./urlService1"; 

export default function ShortURL(){ 
    

    const [url,seturl] = useState('')
   
    let link = {
        url:url
    }
    

    const saveLink=()=>{
        console.log(JSON.stringify(link));
        urlService1.addUrl(link).then(res=>{
            alert(res.data) 
           

        }) 
    }
    return (
        <div className="container-md">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">enter URL</h2>
                        <input
                        className="form-control" 
                        label="URL"  
                        type={"text"}  
                        name="URL"  
                        value={url} onChange={(e)=> seturl(e.target.value)}/> 
                         <button  
                            type="submit" className="btn btn-outline-primary m-4"
                            onClick={() =>saveLink()}>create Short URL</button>
                </div>
            </div>
 
        </div>

        )

}

