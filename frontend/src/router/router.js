import HomeComponent from '../components/Home.vue'
import TestComponent from '../components/Test.vue'
import { createRouter, createWebHistory} from 'vue-router'

const routes = [
    {path: '/', name: 'HomeComponent', component: HomeComponent},
    {path: '/page1', name: 'TestComponent', component: TestComponent}
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes,
});

export default router;