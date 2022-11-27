import HomeComponent from '../components/Home.vue'
import { createRouter, createWebHistory} from 'vue-router'

const routes = [
    {path: '/', name: 'HomeComponent', component: HomeComponent}
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes,
});

export default router;