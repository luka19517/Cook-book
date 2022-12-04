import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config'
import router from './router/router';
import myHeader from './components/MyHeader.vue';

import 'primevue/resources/themes/lara-light-indigo/theme.css';
import 'primevue/resources/primevue.min.css';
import '/node_modules/primeflex/primeflex.css'

import Button from 'primevue/button';
import Menubar from 'primevue/menubar';
import Image from 'primevue/image';
import InputText from 'primevue/inputtext';
import Textarea from 'primevue/textarea';
import OrderList from 'primevue/orderlist';
import Dialog from 'primevue/dialog';
import AutoComplete from 'primevue/autocomplete';
import Listbox from 'primevue/listbox';

import 'primeicons/primeicons.css';

const app = createApp(App);

app.use(router);
app.use(PrimeVue);

app.component('PVButton', Button);
app.component('PVMenuBar', Menubar);
app.component('PVImage', Image);
app.component('PVInputText', InputText);
app.component('PVOrderList', OrderList);
app.component('PVDialog', Dialog);
app.component('PVTextarea', Textarea);
app.component('PVAutoComplete', AutoComplete)
app.component('PVListbox', Listbox)

app.component('myHeader', myHeader);

app.mount('#app')
