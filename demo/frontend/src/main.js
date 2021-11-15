import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueCookies from 'vue-cookies'
import { store } from "./store";
import './index.css'
import Axios from 'axios';

// Axios.defaults.baseURL =
Vue.prototype.$http = Axios;
Vue.config.productionTip = false

Vue.use(VueCookies);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')