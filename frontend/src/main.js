import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config'
import router from './router/router';
import myHeader from './components/MyHeader.vue';

import 'primevue/resources/themes/lara-light-indigo/theme.css';
import 'primevue/resources/primevue.min.css'; 

import Button from 'primevue/button';

const app = createApp(App);

app.use(router);
app.use(PrimeVue);

app.component('PVButton',Button);
app.component('myHeader',myHeader);

app.mount('#app')
