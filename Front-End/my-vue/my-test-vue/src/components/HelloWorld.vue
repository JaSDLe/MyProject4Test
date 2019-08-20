<template>
  <div>
    <input type="button" value="测试" @click="loadUser()" />
    <input type="button" value="测试1" @click="loadUser1()" />
    <!-- <div>
      <form enctype="multipart/form-data" method="post" action="http://localhost:1001/upload">
        <input type="file" name="file" />
        <input type="submit" value="上传" />
      </form>
    </div>-->
    <div>
      <form>
        <input type="file" name="file" multiple="multiple" @change="getFile($event)" />
        <button type="button" @click="submitForm($event)">提交</button>
      </form>
    </div>
    <a href="http://localhost:1001/down/a.txt">a.txt</a>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      file: []
    };
  },
  methods: {
    loadUser() {
      axios
        .get("http://localhost:1001/userc")
        .then(function(response) {
          alert(JSON.stringify(response));
        })
        .catch(function(error) {
          alert(JSON.stringify(error));
        });
    },
    loadUser1() {
      axios({
        method: "get",
        url: "http://localhost:1001/user"
      })
        .then(result => {
          alert(JSON.stringify(result));
        })
        .catch(err => {
          alert(JSON.stringify(err));
        });
    },
    getFile(event) {
      // for (let i = 0; i < event.target.files.length; i++) {
      //   this.file[i] = event.target.files[i];
      // }
      this.file = event.target.files;
      console.log(this.file);
    },
    submitForm(event) {
      if (
        this.file == "" ||
        this.file == null ||
        this.file == undefined ||
        this.file.length == 0
      ) {
        this.$message.warning("cannot upload null");
        return false;
      }
      event.preventDefault();
      let formData = new FormData();
      for (let i = 0; i < this.file.length; i++) {
        formData.append("file", this.file[i]);
      }
      // formData.append("file", this.file);
      console.log(formData.get("file"));
      let config = {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      };
      axios
        .post("http://localhost:1001/upload", formData, config)
        .then(result => {
          var status = result.data.status;
          var message = result.data.message;
          if (status == 200) {
            this.$message.success(message);
          } else if (status == 500) {
            this.$message.error(message);
          }
        });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
