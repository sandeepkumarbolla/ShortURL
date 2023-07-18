import axios from "axios"; 
class urlService1{ 
    addUrl(link){
        return axios.post("http://localhost:8080/addurl",link);
    }
}
export default new urlService1()