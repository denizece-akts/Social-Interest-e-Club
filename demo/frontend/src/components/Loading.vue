<template>
  <div class="widget">
    <div class="loader" :style="{width: width + 'px', height: width + 'px'}"></div>
  </div>
</template>

<script>
  export default {
    name: "Loading",
    props: ['width']
  }
</script>

<style>
.widget {
  position: absolute;
  top:0;
  background: black;
  opacity: .7;
  width: 100%;
  height: 100%;
  display: flex;
}

.loader {
  animation: spin 1s linear infinite;
  -webkit-animation: spin 1s linear infinite;
  margin: auto;
  border-radius: 50%;
  background: transparent;
  border: 5px solid #ddd;
  border-top: 5px solid #3490dc;
}
@-webkit-keyframes spin {
  to {
    border-top-color: #e3342f;
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
@keyframes spin {
  to {
    border-top-color: #e3342f;
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
</style>