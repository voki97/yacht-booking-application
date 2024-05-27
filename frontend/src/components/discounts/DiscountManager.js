import discountService from "@/components/discounts/DiscountService";

export default{
    name:"DiscountManager",
    data(){
        return{
            discountCode: null,
            discount: null,
            error: null
        }
    },
    methods:{
        async getDiscountByCode(code){
            if(code!==null||undefined){
                try{
                    this.discount = await discountService.getDiscount(code)
                    this.sendDiscount()
                }catch(error){
                    this.error = error.message
                }
            }
        },
        sendDiscount(){
           if(this.discount){
               this.$emit('sendDiscount',this.discount.discountId)
           }
        }
    }
}