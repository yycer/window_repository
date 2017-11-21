import numpy as np
import matplotlib.pyplot as plt
import sys,os,caffe
import json


caffe_root = '/home/ubuntu/caffe/' 
sys.path.insert(0, caffe_root + 'python')
os.chdir(caffe_root)

solver = caffe.SGDSolver('examples/cifar10/cifar10_quick_solver.prototxt')

niter = 4000
test_interval = 200
train_loss = np.zeros(niter)
test_acc = np.zeros(int(np.ceil(niter / test_interval)))
test_loss = np.zeros(int(np.ceil(niter / test_interval)))

def send_data(ite, acc, loss):
	tmp = {'iteration': ite, 'accuracy': acc, 'loss': loss}
	print(json.dumps(tmp, indent = 4))

# the main solver loop
for it in range(niter):
    solver.step(1)  # SGD by Caffe
    
    # store the train loss
    train_loss[it] = solver.net.blobs['loss'].data
    solver.test_nets[0].forward(start='conv1')
    
    if it % test_interval == 0:
        acc = solver.test_nets[0].blobs['accuracy'].data
        loss = solver.test_nets[0].blobs['loss'].data
        print 'Iteration:', it, 'testing...', 'accuracy:', acc
        print 'Iteration:', it, 'testing...', 'loss:',loss
        test_acc[it // test_interval] = acc
        test_loss[it // test_interval] = loss
        send_data(it // test_interval, test_acc[it // test_interval], test_loss[it // test_interval])
