//
//  ViewController.swift
//  kotlinmultiplatform
//
//  Created by Yasir Ali on 15/06/2019.
//  Copyright © 2019 Yasir Ali. All rights reserved.
//

import UIKit
import KotlinShared

class ViewController: UIViewController, UICollectionViewDataSource, UICollectionViewDelegate {
    @IBOutlet weak var usersCollectionView: UICollectionView!
    
    var usersList = [User]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        ApplicationApi().users { (users: [User]) -> KotlinUnit in
            print(users[0].name)
            self.usersList = users
            for user in users {
                // make copies of user objects to increase the scrolling
                self.usersList.append(user)
            }
            self.usersCollectionView.reloadData()
            return .init()
        }
    }

    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return usersList.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "Cell", for: indexPath) as! CollectionViewCell
        cell.nameLabel.text = usersList[indexPath.item].name
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        print(indexPath.item)
    }

}

