import axios from "axios";

const BASE_REST_API_URL = "http://localhost:8089"

class CustomerService{
    getLoggedInCustomerDetailsHandler(){
        return axios.get(BASE_REST_API_URL+'/customer/current');
    }

}
