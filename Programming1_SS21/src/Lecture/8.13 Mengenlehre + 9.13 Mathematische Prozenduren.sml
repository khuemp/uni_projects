(*Sei G = (V,E) ein Graph.

• Ein Knoten w heißt Nachfolger eines Knotens v, wenn (v,w) ∈ E.

• Ein Knoten v heißt Vorgänger eines Knotens w, wenn (v,w) ∈ E.

• Zwei Knoten v und w heißen benachbart oder adjazent, wenn (v,w) ∈ E oder (w,v) ∈ E.

• Ein Pfad/con đường/ ist ein nichtleeres Tupel 〈v1,...,vn〉, sodass für alle i ∈ {1,... ,n − 1} gilt: (vi,vi+1) ∈ E. Dabei wird n − 1 als die Länge, v1 als der Ausgangspunkt und vn als der Endpunkt des Pfades bezeichnet. Wir sagen auch, dass der Pfad von v1 nach vn führt.

• Ein Pfad heißt einfach, wenn er keinen Knoten mehrfach enthält.= một đường thẳng/TG.17e/

• Ein Pfad 〈v1,...,vn〉heißt Zyklus, wenn n ≥ 2, v1 = vn und 〈v1,...,vn−1〉einfach ist.

• Ein Knoten w ist von einem Knoten v aus erreichbar, wenn ein Pfad von v nach w existiert.

• Ein Knoten heißt Wurzel, wenn von ihm aus alle Knoten erreichbar sind.

• Ein Knoten heißt Quelle oder initial, wenn er keinen Vorgänger hat.

• Ein Knoten heißt Senke oder terminal, wenn er keinen Nachfolger hat.

• Ein Knoten heißt isoliert, wenn er initial und terminal ist.*);

(*Ein Graph heißt
• endlich, wenn er nur endlich viele Knoten hat.
• symmetrisch, wenn er für jede Kante (v,w) auch die Kante (w,v) hat.
• gewurzelt, wenn er eine Wurzel hat.
• zyklisch, wenn er einen Zyklus enthält.*);

(*Abbildung 8.2:
{(1,5),(1,2),(2,5),(2,3),(3,4),(4,2),(6,4)}
Die Tiefe eines endlichen Graphen mit mindestens einem Knoten ist die maximale Län-
ge seiner einfachen Pfade. Der Graph in Abbildung 8.2 hat die Tiefe 3.*);

(*Den symmetrischen Abschluss eines Graphen erhält man, indem man für jede Kante (v,v) die inverse Kante (v,v) hinzufügt. Hier ist der symmetrische Abschluss des Graphen in Abbildung 8.2:trang 164*);

(*Ein Graph heißt stark zusammenhängend, wenn jeder seiner Knoten von jedem seiner Knoten aus erreichbar ist. Ein Graph heißt zusammenhängend, wenn sein symmetrischer Abschluss stark zusammenhängend ist. Der Graph in Abbildung 8.2 ist zusammenhängend, aber nicht stark zusammenhängend.*);

(*Ein Graph heißt baumartig, wenn er eine Wurzel ohne Vorgänger hat und wenn seine anderen Knoten alle genau einen Vorgänger haben. Hier ist ein Beispiel für einen baumartigen Graphen:*);