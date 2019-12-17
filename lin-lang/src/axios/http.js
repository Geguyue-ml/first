import axios from 'axios'
import QS from 'qs'

axios.defaults.baseURL = 'http://106.13.189.141:10013/web/swagger-ui.html#/';
axios.defaults.timeout = 10000;
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'

export function get(url, param){
    return new Promise((resolve, reject) => {
        axios.get(url, {
            param
        }).then( res => {
            resolve(res.dat)
        }).catch( err => {
            reject(err.data)
        } )
    })
}

export function post(url, params) {
    return new Promise((resolve, reject) => {
         axios.post(url, QS.stringify(params))
        .then(res => {
            resolve(res.data);
        })
        .catch(err =>{
            reject(err.data)
        })
    });
}