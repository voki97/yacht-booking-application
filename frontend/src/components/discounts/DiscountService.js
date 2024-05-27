import {DISCOUNT_GET_BY_CODE_ENDPOINT} from "@/config";
import Discount from "@/models/Discount";

class DiscountService{
    async getDiscount(code){
        const response= await fetch(DISCOUNT_GET_BY_CODE_ENDPOINT.replace(':code', code), {
            method: "GET"
        })
        if(!response.ok){
            throw new Error('Failed to get discount by code: '+code+'!')
        }
        else{
            const data = await response.json()
            return new Discount(
                data.discountId,
                data.code,
                data.type,
                data.value,
                data.startDate,
                data.endDate
            )
        }
    }
}
export default new DiscountService