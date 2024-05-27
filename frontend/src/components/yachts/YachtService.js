import {GET_ALL_YACHTS_ENDPOINT} from "@/config";
import {GET_BY_ID_YACHT_ENDPOINT} from "@/config";
import Yacht from "@/models/Yacht";

class YachtService{
    async getAll(){
        const response = await fetch(GET_ALL_YACHTS_ENDPOINT, {
            method: "GET"
        })
        if(!response.ok){
            throw new Error('Failed to get all Yachts!')
        }
        else
        {
            return await response.json();
        }
    }
    async getById(id){
        const response = await fetch(GET_BY_ID_YACHT_ENDPOINT.replace(':id', id), {
            method: "GET"
        })
        if(!response.ok){
            throw new Error('Failed to get yacht by ID: '+id+'!')
        }
        else{
            const data = await response.json()
            return new Yacht(data.yachtId, data.name, data.type, data.pricePerDay)
        }

    }
}
export default new YachtService