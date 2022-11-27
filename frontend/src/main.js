import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config'
import router from './router/router';

const app = createApp(App);

app.use(router);
app.use(PrimeVue);


app.component()

app.mount('#app')
