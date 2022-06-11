# -*- coding: utf-8 -*-
"""ReconocimientoFacial.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1GfroDGhTSrWCEpqaLr3sn6Yrsby-z0Ym
"""

from google.colab import drive
drive.mount('/content/gdrive')
!pip install mtcnn

from google.colab import drive
drive.mount('/content/drive')

from google.colab import files

!cp /content/drive/MyDrive/ProyectoReconocedorFacial/ReconocimientoFacial/utils.py /content

import os
import sys
import pickle
import numpy as np
import matplotlib.pyplot as plt
from scipy.spatial.distance import cosine
import cv2
import mtcnn
from keras.models import load_model
sys.path.append('..')
from google.colab.patches import cv2_imshow
from utils import get_face, l2_normalizer, normalize, save_pickle, plt_show, get_encode

encoder_model = '/content/drive/MyDrive/ProyectoReconocedorFacial/ReconocimientoFacial/modelos/facenet_keras.h5'
people_dir = '/content/drive/MyDrive/ProyectoReconocedorFacial/ReconocimientoFacial/personas'
encodings_path = '/content/drive/MyDrive/ProyectoReconocedorFacial/ReconocimientoFacial/codificaciones/encodings.pkl'

recognition_t = 0.3
required_size = (160, 160)
encoding_dict = dict()

face_detector = mtcnn.MTCNN()
face_encoder = load_model(encoder_model)

face_encoder.summary()

for person_name in os.listdir(people_dir):
    person_dir = os.path.join(people_dir, person_name)
    encodes = []
    for img_name in os.listdir(person_dir):
        img_path = os.path.join(person_dir, img_name)
        img = cv2.imread(img_path)
        img_rgb = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
        results = face_detector.detect_faces(img_rgb)
        if results:
            res = max(results, key=lambda b: b['box'][2] * b['box'][3])
            face, _, _ = get_face(img_rgb, res['box'])
            
            face = normalize(face)
            face = cv2.resize(face, required_size)
            encode = face_encoder.predict(np.expand_dims(face, axis=0))[0]
            encodes.append(encode)
    if encodes:
        encode = np.sum(encodes, axis=0)
        encode = l2_normalizer.transform(np.expand_dims(encode, axis=0))[0]
        encoding_dict[person_name] = encode

for key, val in encoding_dict.items():
    print(key, val.shape)

save_pickle(encodings_path, encoding_dict)

test_img_path = '/content/drive/MyDrive/ProyectoReconocedorFacial/ReconocimientoFacial/Pruebas/Familia2.jpg'
test_res_path = '/content/drive/MyDrive/Escuela/Colab_Notebooks/ReconocimientoFacial/result/Familia2.jpg'

img = cv2.imread(test_img_path)
plt_show(img)

img_rgb = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
results = face_detector.detect_faces(img_rgb)
for res in results:
    face, pt_1, pt_2 = get_face(img_rgb, res['box'])
    encode = get_encode(face_encoder, face, required_size)
    encode = l2_normalizer.transform(np.expand_dims(encode, axis=0))[0]
    
    name = 'unknown'
    distance = float("inf")
    
    for db_name, db_encode in encoding_dict.items():
        dist = cosine(db_encode, encode)
        if dist < recognition_t and dist < distance:
            name = db_name
            distance = dist
    if name == 'unknown':
        cv2.rectangle(img, pt_1, pt_2, (0,0, 255),1)
        cv2.putText(img,name, pt_1,cv2.FONT_HERSHEY_PLAIN, 1, (0,0,255), 1)
    else:
        cv2.rectangle(img, pt_1, pt_2, (0, 255, 0),1)
        cv2.putText(img,name + f"__{distance:.2f}", pt_1 ,cv2.FONT_HERSHEY_PLAIN, 1, (0,255,0), 1)

plt_show(img)
cv2.imwrite(test_res_path,img)