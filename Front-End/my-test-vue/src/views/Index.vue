<template>
  <div>
    <button @click="loadCORSPage">CORS</button>
    <button @click="loadFilePage">File</button>
    <button @click="loadPagePage">Page</button>
    <el-button @click="openDialog">dialog</el-button>
    <el-dialog
      :close-on-click-modal="false"
      :visible.sync="treeDialogVisible"
      :title="treeDialogTitle"
      :before-close="handleDialogClose"

      id="dialog">
      <div ref="myEchart" style="border:1px dashed #000;height: 300px"></div>
    </el-dialog>
  </div>
</template>

<script>
    // 引入 ECharts 主模块height: 800pxfullscreen="false"
    let echarts = require('echarts/lib/echarts');
    // 引入树形图
    require('echarts/lib/chart/tree')
    // 引入提示框
    require('echarts/lib/component/tooltip')
    export default {
        data() {
            return {
                treeDialogVisible: false,
                treeDialogTitle: 'null',
                myChart: null,
                data: {
                    'name': 'a',
                    'children': [{'name': 'b', 'children': [{'name': 'c', 'children': []}]}, {
                        'name': 'b',
                        'children': [{'name': 'c', 'children': []}]
                    }, {'name': 'b', 'children': [{'name': 'c', 'children': []}]}, {
                        'name': 'b',
                        'children': [{'name': 'c', 'children': []}]
                    }, {'name': 'b', 'children': [{'name': 'c', 'children': []}]}, {
                        'name': 'b',
                        'children': [{'name': 'c', 'children': []}]
                    }, {'name': 'b', 'children': [{'name': 'c', 'children': []}]}]
                }
            }
        },
        methods: {
            handleDialogClose(done) {
                this.myChart.dispose()
                this.myChart = null
                done()
            },
            drawTree() {
                console.log(document.getElementById('dialog'))
                this.myChart = echarts.init(this.$refs.myEchart)
                // this.myChart = echarts.init(document.getElementById('myChart'))

                this.myChart.setOption({
                    tooltip: {
                        trigger: 'item',
                        triggerOn: 'mousemove'
                    },
                    series: [
                        {
                            type: 'tree',
                            data: [this.data],
                            // top: "1%",
                            // left: "7%",
                            // bottom: "1%",
                            // right: "20%",
                            roam: true,
                            symbolSize: 10,
                            label: {
                                normal: {
                                    position: 'bottom',
                                    align: 'left',
                                    offset: [-10, 0],
                                    fontSize: 12
                                }
                            },
                            leaves: {
                                label: {
                                    normal: {
                                        position: 'right',
                                        verticalAlign: 'middle',
                                        offset: [0, 0],
                                        align: 'left'
                                    }
                                }
                            },
                            expandAndCollapse: true
                            // animationDuration: 550,
                            // animationDurationUpdate: 750
                        }
                    ]
                })
            },
            openDialog() {
                this.treeDialogVisible = true
                this.$nextTick(() => {
                    this.drawTree()
                })
            },
            loadCORSPage() {
                this.$router.push({path: '/cors'})
            },
            loadFilePage() {
                this.$router.push({path: '/file'})
            },
            loadPagePage() {
                this.$router.push({path: '/page'})
            }
        }
    };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
