<template>
  <div id="allTask">
    {{ queryData.name }}
  </div>
</template>

<script>
export default {
  name: 'AllTask',
  data () {
    return {
      
    }
  },
  props: {
    queryData: {
      type: String,
      required : true
    }
  },
  methods: {

  }
}
</script>

<style scoped>

</style>
