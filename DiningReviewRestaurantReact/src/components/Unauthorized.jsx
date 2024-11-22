import { useState } from "react";
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Button from '@mui/material/Button';

export default function Unauthorized() {
    const [closed, setClose] = useState(true)

    const handleClose = () => {
        SetClose(false);
      };

    return (
        <>
            <Dialog closed={closed} onClick={handleClose}>
                <DialogTitle>
                    {"Texto qualquer"}
                </DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        dkasdjasdjhakjshdkjads
                    </DialogContentText>
                    <DialogActions>
                        <Button onClick={handleClose}>Fechar</Button>
                        <Button onClick={handleClose} autoFocus></Button>
                    </DialogActions>
                </DialogContent>
            </Dialog>
        </>
    )
}