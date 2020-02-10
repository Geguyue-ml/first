<template>
    <div class="modelBox Btn">
        <div>
          <router-link v-if="prev" class="npBtn prev" tag="div" :to="{name: 'flowPath' + prev}"></router-link>
          <div v-if="next && next != 6" class="npBtn next" @click="taskChange(next)"></div>
          <div v-else class="npBtn next" @click="taskPay()"></div>
        </div>
    </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'TaskModel',
  data () {
    return {
      newPrev: this.prev
    }
  },
  props: {
    next: {
      type: Number
    },
    prev: {
      type: Number
    }
  },
  methods: {
      ...mapMutations(["taskChange"]),
      taskPay(){
        this.$emit('showFlow');
      },
      subChange(){
        this.newPrev = 11
      },
      taskChange(){
        this.$parent.saveData()
      },
      nextGo(){
        this.$router.push({ path: 'flowPath' + this.next })
      }
  }
}
</script>

<style scoped>

</style>
