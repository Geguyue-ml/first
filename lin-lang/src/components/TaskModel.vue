<template>
    <div class="modelBox Btn">
        <div>
          {{prev}}
          <div @click="subChange">子组件按钮</div>
          <router-link v-if="prev" class="npBtn prev" tag="div" :to="{name: 'flowPath' + prev}" @click.native="taskOk(prev)"></router-link>
          <router-link v-if="next && next != 6" class="npBtn next" tag="div" :to="{name: 'flowPath' + next}" @click.native="taskOk(next)"></router-link>
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
      ...mapMutations(["taskOk"]),
      taskPay(){
        this.$emit('showFlow');
      },
      subChange(){
        this.newPrev = 11
      }
  },
  watch: {
    "newPrev": function(newVal){
      // this.$parent.change1(newVal)
      this.$emit("update:prev", newVal)
    }
  }
}
</script>

<style scoped>

</style>
