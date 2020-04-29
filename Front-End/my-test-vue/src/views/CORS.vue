<template>
  <div>
    <input type="button" value="CORS测试" @click="loadUser()" />
    <input type="button" value="测试" @click="loadUser1()" />
    <div>
      <h1>{{title}}</h1>
      <pre>{{tip}}</pre>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "",
      tip: ""
    };
  },
  methods: {
    loadUser() {
      var _this = this;
      this.$axios
        .get("http://localhost:1001/userc")
        .then(function(response) {
          _this.title = "SUCCESS";
          _this.tip = response;
          // alert(JSON.stringify(response));
        })
        .catch(function(error) {
          _this.title = "ERROR";
          _this.tip = error;
          // alert(JSON.stringify(error));
        });
    },
    loadUser1() {
      var _this = this;
      this.$axios({
        method: "get",
        url: "http://localhost:1001/user"
      })
        .then(result => {
          _this.title = "SUCCESS";
          _this.tip = result;
          // alert(JSON.stringify(result));
        })
        .catch(err => {
          _this.title = "ERROR";
          _this.tip = err;
          // alert(JSON.stringify(err));
        });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
