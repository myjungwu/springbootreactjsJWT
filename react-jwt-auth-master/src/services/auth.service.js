import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "signin", {
        username,
        password
      })
      .then(response => {
        console.log("login 응답데이터 헤더" + JSON.stringify(response));
        let user = {};
        if(response.headers['access-token']) {
          user = response.data;
          user.accessToken = response.headers['access-token'];
          localStorage.setItem("user", JSON.stringify(user));
        }
        return user;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(username, email, password) {
    return axios.post(API_URL + "signup", {
      username,
      email,
      password
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));
  }
}

export default new AuthService();
