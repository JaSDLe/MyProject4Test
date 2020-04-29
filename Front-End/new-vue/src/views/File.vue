<template>
  <div>
    <div>
      <div>上传</div>
      <div>
        <form>
          <input type="file" name="file" multiple="multiple" @change="getFile($event)" />
          <button type="button" @click="submitForm($event)">提交</button>
        </form>
      </div>
    </div>

    <div>
      <div>下载</div>
      <a href="http://localhost:1001/dl/a.txt">a.txt</a>
      <button @click="download">a.txt</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      file: []
    };
  },
  methods: {
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
      this.$axios
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
    },
    download() {
      this.$axios
        .get("http://localhost:1001/dl/a.txt")
        .then(response => {
          // alert(JSON.stringify(response.data));, { responseType: "blob" }

          const elink = document.createElement("a");
          elink.href = "http://localhost:1001/dl/a.txt";
          elink.click();

          // const blob = new Blob([response.data]);
          // let fileName = "a.txt";
          // // if ("download" in document.createElement("a")) {
          // //   // 非IE下载
          //   const elink = document.createElement("a");
          //   elink.download = fileName;
          //   elink.style.display = "none";
          //   elink.href = URL.createObjectURL(blob);
          //   // document.body.appendChild(elink);
          //   elink.click();
          //   URL.revokeObjectURL(elink.href); // 释放URL 对象
          // document.body.removeChild(elink);
          // } else {
          //   // IE10+下载
          //   navigator.msSaveBlob(blob, fileName);
          // }
          // resolve(response);
        })
        .catch(error => {
          this.$message.error(error.response.data.message);
          // alert(JSON.stringify(error.response.data.message));
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
