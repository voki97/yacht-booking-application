import {createApp} from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from 'vue-router'; // Import createRouter and createWebHistory
import YachtsDisplay from "@/components/yachts/YachtsDisplay.vue";
import BookAYacht from "@/components/bookings/BookAYacht.vue";

const routes = [
    {path: '/', component: YachtsDisplay},
    {
        path: '/book_yacht/:yachtId', component: BookAYacht, props: (route) => {
            const yachtId = route.params.yachtId;
            return {yachtId}
        }
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

const app = createApp(App);
app.use(router); // Use the router
app.mount('#app');
