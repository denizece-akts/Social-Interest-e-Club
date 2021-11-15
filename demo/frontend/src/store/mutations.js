export default {
    increment(state) {
        state.count++
    },
    setUserLoggedIn(state){
        state.isLoggedIn = true;
    },
    setUser(state, user){
        state.user = user;
    }
}