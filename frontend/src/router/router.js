import HomeComponent from '../components/Home.vue'
import CreateReceipt from '../components/CreateReceipt.vue'
import ReceiptTypeListComponent from '../components/ReceiptTypeList.vue'
import { createRouter, createWebHistory} from 'vue-router'

const routes = [
    {path: '/', name: 'HomeComponent', component: HomeComponent},
    {path:'/receipt/create', name: 'CreateReceiptComponent', component: CreateReceipt},
    {path:'/receipttype/all', name: 'ReceiptTypeListComponent', component: ReceiptTypeListComponent}
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes,
});

export default router;
